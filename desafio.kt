enum class Nivel { INICIANTE, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val id: Long)

data class ConteudoEducacional(val nome: String, val stack: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    val inscritos = mutableListOf<Usuario>()
    
    infix fun matricular(usuario: Usuario) { inscritos.add(usuario) }

    fun matricular(vararg usuarios: Usuario){
        for(usuario in usuarios)
            inscritos.add(usuario)
    }

    fun mostrarConteudos(){
        for(conteudo in conteudos)
            println(conteudo.nome)
    }

    fun mostrarInscritos(){
        for(inscrito in inscritos)
            println(inscrito.nome)
    }
}

fun main() {
    // Criando os usuários
    val diego = Usuario("Diego", 1L)
    val gabriel = Usuario("Gabriel", 2L)
    val brenda = Usuario("Brenda", 3L)
    val medeiros = Usuario("Medeiros", 4L)
    val bruno = Usuario("Bruno", 5L)

    // Criando a lista de conteúdos da formação
    val listaConteudosKotlin: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Introdução ao Desenvolvimento Moderno de Software","Kotlin"),
        ConteudoEducacional("Java e Sua História","Java"),
        ConteudoEducacional("Orientação a Objetos - POO","Java"),
    	ConteudoEducacional("Arquiteturas e Organizações Computacionais","Fundamentos Hardware"))

    // Criando a formação para Kotlin
    val kotlinExperience = Formacao("Kotlin Experience", listaConteudosKotlin, Nivel.INICIANTE)

    // Verificando se a variável de formação não é nula, caso não seja, matriculando alunos
    kotlinExperience?.let{
        kotlinExperience.matricular(diego, gabriel, brenda, medeiros, bruno)
    }

    // Imprimindo na tela
    println("Formação: ${kotlinExperience.nome}\n\t\tConteúdos:")
    kotlinExperience.mostrarConteudos()
    println("\t\tInscritos:")
    kotlinExperience.mostrarInscritos()
    println("____________________________________________________________")

}