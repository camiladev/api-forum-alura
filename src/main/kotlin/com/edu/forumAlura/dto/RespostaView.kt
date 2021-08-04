package com.edu.forumAlura.dto

import com.edu.forumAlura.model.Topico
import java.time.LocalDateTime

data class RespostaView(
    var id: Long?,
    val mensagem: String,
    val dataCriacao: LocalDateTime,
    val topico: Topico
)
