package com.edu.forumAlura.mapper

import com.edu.forumAlura.dto.NovoTopicoForm
import com.edu.forumAlura.model.Topico
import com.edu.forumAlura.service.CursoService
import com.edu.forumAlura.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico> {

    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}
