package com.edu.forumAlura.dto

import javax.validation.constraints.NotEmpty

data class AtualizacaoRespostaForm(

    @field:NotEmpty
    val mensagem: String,

    val id: Long
)