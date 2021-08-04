package com.edu.forumAlura.mapper

import com.edu.forumAlura.dto.RespostaView
import com.edu.forumAlura.model.Resposta
import org.springframework.stereotype.Component

@Component
class RespostaViewMapper: Mapper<Resposta, RespostaView> {

    override fun map(t: Resposta): RespostaView {
        TODO("Not yet implemented")
    }

}
