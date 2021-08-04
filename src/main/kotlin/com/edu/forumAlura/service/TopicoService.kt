package com.edu.forumAlura.service

import com.edu.forumAlura.dto.AtualizaTopicoForm
import com.edu.forumAlura.dto.NovoTopicoForm
import com.edu.forumAlura.dto.TopicoView
import com.edu.forumAlura.exception.NotFoundException
import com.edu.forumAlura.mapper.TopicoFormMapper
import com.edu.forumAlura.mapper.TopicoViewMapper
import com.edu.forumAlura.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "topic.not.found"
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map {
                top -> topicoViewMapper.map(top)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { top ->
            top.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualiza(form: AtualizaTopicoForm): TopicoView {
        val topico = topicos.stream().filter { top ->
            top.id == form.id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { top ->
            top.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        topicos = topicos.minus(topico)
    }
}