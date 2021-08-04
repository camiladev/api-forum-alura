package com.edu.forumAlura.service

import com.edu.forumAlura.model.Curso
import com.edu.forumAlura.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(
    var usuarios: List<Usuario>
) {
    init {
        val usuario = Usuario(
            id = 1,
            nome = "Camila Matos",
            email = "camila@email.com"
        )
        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter({
                user -> user.id == id
        }).findFirst().get()
    }

}
