package com.edu.forumAlura.mapper

import com.edu.forumAlura.dto.NovaRespostaForm
import com.edu.forumAlura.model.Resposta
import com.edu.forumAlura.service.TopicoService
import com.edu.forumAlura.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RespostaFormMapper(
    private val usuarioService: UsuarioService,
    private val topicoService: TopicoService
): Mapper<NovaRespostaForm, Resposta> {

    override fun map(t: NovaRespostaForm): Resposta {
        return Resposta(
            mensagem = t.mensagem,
            solucao = t.solucao,
            autor = usuarioService.buscarPorId(t.idAutor),
            topico = topicoService.buscarPorId(t.idTopico)
        )
    }

}
