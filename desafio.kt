// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario (val nome: String, val dataNascimento: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(var nome: String, var conteudos: List<ConteudoEducacional>, var nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Parabéns '${usuario.nome}', você está matriculado(a) na formação '$nome'!")
    }
}

fun main() {
    //criando conteúdos educacionais (cursos)
    val conteudoEducacional1 = ConteudoEducacional("Trabalhando em Equipes Ágeis", 180, Nivel.BASICO)
    val conteudoEducacional2 = ConteudoEducacional("Versionamento de Código com Git e GitHubs", 120, Nivel.BASICO)
    val conteudoEducacional3 = ConteudoEducacional("Tratamento de Exceções em Kotlin", 120, Nivel.AVANCADO)
    
    //criando lista de conteúdos educacionais
    var listaConteudosEducacionais = listOf(conteudoEducacional1, conteudoEducacional2, conteudoEducacional3)
        
    //criando formação
    val formacao = Formacao("Bootcamp Back-end Kotlin NTT DATA", listaConteudosEducacionais, Nivel.INTERMEDIARIO)
    
    //criando usuários
    val usuario1 = Usuario(nome = "João", dataNascimento = "10/10/1996")
    val usuario2 = Usuario(nome = "Maria", dataNascimento = "15/12/2000")
    val usuario3 = Usuario(dataNascimento = "25/08/2003", nome = "Pedro")
    val usuario4 = Usuario(dataNascimento = "25/03/1985", nome = "Júlia")
    
    //matriculando alunos nas formações
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario3)
    formacao.matricular(usuario4)
    
   println("\nQuantidade de alunos matriculados na formação '${formacao.nome}': ${formacao.inscritos.count()}")
   println("Quantidade de cursos da formação '${formacao.nome}': ${formacao.conteudos.count()}")
   println("Carga horária da formação '${formacao.nome}': ${formacao.conteudos.sumOf { it.duracao }} minutos")
   
}