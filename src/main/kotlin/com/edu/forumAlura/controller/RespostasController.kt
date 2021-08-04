package com.edu.forumAlura.controller

import com.edu.forumAlura.dto.AtualizacaoRespostaForm
import com.edu.forumAlura.dto.NovaRespostaForm
import com.edu.forumAlura.dto.RespostaView
import com.edu.forumAlura.model.Resposta
import com.edu.forumAlura.service.RespostaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("topicos/{id}/respostas")
class RespostasController(
    private val service: RespostaService
) {

    @GetMapping
    fun listar(@PathVariable id: Long): List<Resposta>{
        return service.listar(id)
    }

    @PostMapping
    fun cadastrar(@PathVariable idTopico: Long, @RequestBody @Valid dto: NovaRespostaForm){
        service.cadastrar(dto, idTopico)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoRespostaForm): ResponseEntity<RespostaView> {
        val respostaView = service.atualizar(form)
        return ResponseEntity.ok(respostaView)
    }

    @DeleteMapping("/{idResposta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable idResposta: Long) {
        service.deletar(idResposta)
    }
}