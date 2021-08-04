package com.edu.forumAlura.model

import com.edu.forumAlura.dto.TopicoView
import java.time.LocalDateTime

data class Resposta(
    var id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    var topico: TopicoView,
    val solucao: Boolean
) {

}
