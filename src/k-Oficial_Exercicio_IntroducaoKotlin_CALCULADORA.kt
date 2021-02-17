import com.sun.jdi.IntegerValue
import java.util.Scanner
import java.lang.NumberFormatException
import java.util.function.ToDoubleFunction

/*
    Programador ................: Dimas Ruy de Lima
    Linguagem ..................: Kotlin
    Última Modificação .........: 2021-02-17 09:01 hs
    Status                      : Finalizado
    Nome do Programa ...........: k-Oficial_Exercicio_IntroducaoKotlin_CALCULADORA.kt
    Objetivo do programa .......: Criar uma calculadora conforme proposto pelo curso ( Everis - Digital Innovation One )

    Nível deste tópico .........: Refere-se a lição :  Introdução ao Kotlin / Basico / 6 horas
*/

// .................................. MINHA CALCULADORA ..................................
// Esta calculadora tem um controle de digitação de operador errado limitando a quatro tentativas e com tratamento de erros
var Operador    = ""
var wContinuar  = "S"
var contador    = 0

fun main() {
    selTipoOper()
    when (Operador){
        "+" -> somar()
        "-" -> subtrair()
        "*" -> multiplicar()
        "/" -> dividir()
        "%" -> porcentagem()
    }
}

// -------------------------------------------- INICIO DAS FUNÇÕES ---------------------------------------------------

fun selTipoOper() {
    var statusTipoOper = false
        contador    = 0
// Criando uma condição para a digitação do Tipo de Operador que que o programa não abortar se digitar um operador errado
// Checkin Tipo de Operador

    while (statusTipoOper == false && contador <= 4) {
        try {
            println("> Escolha um tipo de Operador ( - + / * % ) .....:  ")
            Operador = readLine().toString()

            if (Operador != "-" && Operador != "+" && Operador != "/" && Operador != "*" && Operador != "%") {
                statusTipoOper = false
                contador += 1
                if (contador == 1) {
                    println("Você digitou o simbolo do Operador ERRADO um total de : $contador vez")
                } else println("Você digitou o simbolo do Operador ERRADO um total de : $contador vezes")

                if (contador == 4) {
                    statusTipoOper = true
                    println("Ultimo Operador ERRADO Escolhido foi :  $Operador O programa foi abortador devido a quatro tentativas de digitação")
                }
            } else {
                println("************************** TIPO ESCOLHIDO : ( $Operador ) **************************")
                statusTipoOper = true
                contador = 4
            }
        } catch (ex: Exception) {
            statusTipoOper = false
            contador += 1
            if (contador == 1) {
                println("Você digitou o simbolo do Operador ERRADO um total de : $contador vez")
                println("> Escolher apenas o tipo de Operador ( -  +  /  *  % )")
            } else println("Você digitou o simbolo do Operador ERRADO um total de : $contador vezes")
            if (contador == 4) statusTipoOper = false
        }
    }
}


fun somar(){
    var statusDig    = false
    var somar        = 0.00f
    var wVal         = 0.00f
        contador     = 1

    println("Opção de calculo : SOMAR\n")
    while (statusDig == false) {
        try {
            if (contador == 1) {
                println("[$contador] > Digite o Primeiro valor para iniciar a SOMA : ")
                wVal = readLine()!!.toFloat()
                contador += 1
                somar += wVal
        } else {
                println("[$contador] > Digite o próximo valor p/SOMAR, para diminuir digitar o sinal de ( - ) ")
                wVal = readLine()!!.toFloat()
                somar += wVal
                println("> Soma dos valores : " + "%.2f".format(somar)  + " - Você digitou : $contador  números para somar")
                contador += 1
            }
            if(contador >= 3){
                msgContinuar()
                val stringInput = readLine()

                if(stringInput == "s" || stringInput == "S"){
                    wContinuar = "S"
                }else{
                    wContinuar = "N"
                    contador  -= 1
                    statusDig  = true
                }
            }
        } catch (ex: Exception) {
            msgTratamentoErro()
            statusDig = false
        }
    }
}


fun subtrair() {
    var statusDig = false
    var resSubtrair  = 0.00f
    var wValorig  = 0.00f
    var wSomasub  = 0.00f
    var wValsub   = 0.00f
        contador  = 1

    while (statusDig == false) {
        try {
            if (contador == 1) {
                println("Opção de calculo : SUBTRAÇÃO, digite o sinal de (-) para subtrair e normal para somar \n")
                println("[$contador] >  Digite o primeiro valor para Subtração  :  ")
                wValorig = readLine()!!.toFloat()
                contador += 1
            } else {
                println("[$contador] > Digite o próximo valor p/subtrair :  ")
                wValsub = readLine()!!.toFloat()
                wSomasub += wValsub
                resSubtrair = wValorig + wSomasub
                println("Saldo da Subtração : " + "%.2f".format(resSubtrair) + " e você digitou : $contador  números para SUBTRAIR")
                contador += 1
            }
            if(contador >= 3) {
                msgContinuar()
                val stringInput = readLine()
                if (stringInput == "s" || stringInput == "S") {
                    wContinuar = "S"
                } else {
                    wContinuar = "N"
                    contador -= 1
                    statusDig = true
                }
            }
        } catch (ex: Exception) {
            msgTratamentoErro()
            statusDig = false
        }
    }
}


fun multiplicar(){
    var wMultiplicar  = 0.00f
    var wValorig      = 0.00f

    while (wContinuar == "S") {
        try {
            println("Calculo de MULTIPLICAÇÃO \n")
            println("> Digite o valor para Multiplicação  :  ")
            wValorig = readLine()!!.toFloat()

            println("> Digite o segundo valor p/multiplicar :  ")
            wMultiplicar = readLine()!!.toFloat()

            println("Valor p/multiplicar foi : " + "%.2f".format(wValorig)  + "   -  Segundo Valor p/multiplicar : " + "%.2f".format(wMultiplicar)  + "   -  Resultado :  {$wValorig * $wMultiplicar} = " +  "%.2f".format(wValorig *  wMultiplicar))

            msgContinuar()
            val stringInput = readLine()
            if(stringInput == "s" || stringInput == "S"){
                wContinuar = "S"
            }else{
                wContinuar = "N"
            }
        } catch (ex: Exception) {
            msgTratamentoErro()
            wContinuar = "S"
        }
    }
}


fun dividir(){
    var wDividir     = 0.00f
    var wValorig     = 0.00f

    while (wContinuar == "S") {
        try {
            println("Calculo de DIVISÃO \n")
            println("> Digite o valor para DIVIDIR  :  ")
            wValorig = readLine()!!.toFloat()

            println("> Digite o segundo valor p/divisão :  ")
            wDividir = readLine()!!.toFloat()

            println("Valor p/dividir foi : " + "%.2f".format(wValorig)  + "  - Segundo Valor p/divisão : " + "%.2f".format(wDividir)  + "   -  Resultado : {$wValorig / $wDividir} = " + "%.2f".format(wValorig /  wDividir) )

            msgContinuar()
            val stringInput = readLine()
            if(stringInput == "s" || stringInput == "S"){
                wContinuar = "S"
            }else{
                wContinuar = "N"
            }

        } catch (ex: Exception) {
            msgTratamentoErro()
            wContinuar = "S"
        }
    }
}


fun porcentagem(){
    var wPorcentagem = 0.00f
    var wValorig     = 0.00f
    var wResultado   = 0.00f

    while (wContinuar == "S") {
        try {
            println("Calculo de PERCENTUAL \n")
            println("> Digite o valor para o Percentual (R$) :  ")
            wValorig = readLine()!!.toFloat()

            println("> Digite o valor em % :  ")
            wPorcentagem = readLine()!!.toFloat()
            wResultado   = ((wValorig * wPorcentagem)/100)  // achando o valor do percentual ( valor do desconto neste caso )
            println("Valor R$ : " +  "%.2f".format(wValorig) + " - Percentual Desconto : " + "%.2f".format(wPorcentagem) + "%  -  Vr do Desdconto R$: " + "%.2f".format(wResultado)  + "   -  Valor C/Desconto R$ = " + "%.2f".format(wValorig - wResultado))
            println("Valor R$ : " +  "%.2f".format(wValorig) + " - Percentual Juros    : " + "%.2f".format(wPorcentagem) + "%  -  Vr Acrescido    R$: " + "%.2f".format(wResultado)  + "   -  Valor C/Juros    R$ = " + "%.2f".format(wValorig + wResultado))

            msgContinuar()
            val stringInput = readLine()
            if(stringInput == "s" || stringInput == "S"){
                wContinuar = "S"
            }else{
                wContinuar = "N"
            }

        } catch (ex: Exception) {
            msgTratamentoErro()
            wContinuar = "S"
        }
    }
}

fun msgContinuar(){
    println("\n Deseja continuar S/N? Favor digite (S) para continuar ou qualquer tecla para sair")
}

fun msgTratamentoErro(){
    println("\nErro na digitação, Favor digitar um valor valido para esta situação, Obrigado!")
}
