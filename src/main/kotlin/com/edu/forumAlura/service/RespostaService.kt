package com.edu.forumAlura.service

import com.edu.forumAlura.dto.AtualizacaoRespostaForm
import com.edu.forumAlura.dto.NovaRespostaForm
import com.edu.forumAlura.dto.RespostaView
import com.edu.forumAlura.mapper.RespostaFormMapper
import com.edu.forumAlura.mapper.TopicoFormMapper
import com.edu.forumAlura.mapper.TopicoViewMapper
import com.edu.forumAlura.model.Curso
import com.edu.forumAlura.model.Resposta
import com.edu.forumAlura.model.Topico
import com.edu.forumAlura.model.Usuario
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class RespostaService(
    private var respostas: List<Resposta> = ArrayList(),
    private val respostaFormMapper: RespostaFormMapper,
    private val topicoService: TopicoService
) {

    fun listar(idTopico: Long): List<Resposta> {
        return respostas.stream().filter { res ->
            res.topico.id == idTopico
        }.collect(Collectors.toList())
    }

    fun cadastrar(form: NovaRespostaForm, idTopico: Long) {
        val resposta = respostaFormMapper.map(form)
        resposta.id = respostas.size.toLong() + 1
        resposta.topico = topicoService.buscarPorId(idTopico)
        respostas = respostas.plus(resposta)
    }

//    fun cadastrar(form: NovaRespostaForm, idTopico: Long) {
//    val reposta = respostaFormMapper.map(form)
//        resposta.id = respostas.size.toLong() + 1
//        resposta.topico = topicoService.buscarPorId(idTopico)
//        respostas = respostas.plus(resposta)
//}

//    fun atualizar(form: AtualizacaoRespostaForm): RespostaView? {
//        val resposta = respostas.stream().filter { r ->
//            r.id == form.id
//        }.findFirst().get()
//        val respostaAtualizada = Resposta(
//            id = form.id,
//            mensagem = form.mensagem,
//            autor = resposta.autor,
//            topico = resposta.topico,
//            dataCriacao = resposta.dataCriacao,
//            solucao = resposta.solucao
//        )
//        respostas = respostas.minus(resposta).plus(respostaAtualizada)
//        return respostaViewMapper.map(respostaAtualizada)
//    }

    fun deletar(idResposta: Long) {
        val resposta = respostas.stream().filter { r ->
            r.id == idResposta
        }.findFirst().get()
        respostas = respostas.minus(resposta)
    }

    fun atualizar(form: AtualizacaoRespostaForm): RespostaView? {
        TODO("Not yet implemented")
    }

//
}