package com.edu.forumAlura.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class NovaRespostaForm(

    @field:NotEmpty
    val mensagem: String,

    val solucao: Boolean,

    @field:NotNull
    val idAutor: Long,

    @field:NotNull
    val idTopico: Long
)
