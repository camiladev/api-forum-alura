package com.edu.forumAlura.controller

import com.edu.forumAlura.dto.AtualizaTopicoForm
import com.edu.forumAlura.dto.NovoTopicoForm
import com.edu.forumAlura.dto.TopicoView
import com.edu.forumAlura.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<TopicoView>{
        return service.listar()
    }

    @GetMapping("{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView{
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid form: NovoTopicoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoView> {
        val topicoView = service.cadastrar(form)
        val uri = uriBuilder.path("topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizaTopicoForm): ResponseEntity<TopicoView>{
        val topicoView = service.atualiza(form)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        service.deletar(id)
    }

}