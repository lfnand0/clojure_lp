(ns clojure-lp.core
  (:gen-class))

; A linguagem Clojure funciona através de funções, que são chamadas entre parênteses;
; Basicamente todas as operações, de álgebra, condicionais, etc são chamadas como funções.
; Como exemplo, enquanto o jeito "normal" de se escrever a soma de 5 e 4 em outras 
; linguagens seria 5 + 4, em Clojure nós chamaremos (+ 5 4), passando os valores 5 e 4 
; à função "+"

(defn funcao ; Chamamos defn para criar uma função
  [valor] ; Valor que a função recebe

  valor ; O retorno da função em clojure apenas precisa ser chamado ao fim
  )

(defn soma
  [valor1 valor2] ; Valores recebidos
  (+ valor1 valor2)) ; Retorna o valor da soma entre esse valores

(defn condicionais-1
  ; Condicionais: if

  ; If: (if (condicao) x y)
  ; Se a condicao for verdadeira, retorna x, senão, retorna y

  [valor]
  (if (> valor 0)
    true
    false) ;A segunda linha dentro do if é equivalente ao "else"
  )
(defn condicionais-2
  ; Condicionais: múltiplas condicionais

  ; Cond: (cond (condição 1) retorno1 (condição 2) retorno2 :else retorno3)
  ; Podemos colocar quantas condições forem necessárias
  ; O :else é utilizado para os casos no qual todas as condicionais são false
  [valor]
  (cond
    (= valor 1) "Valor é 1"
    (= valor 2) "Valor é 2"
    :else "Valor não é 1 nem 2"))


(defn variavel
  [w]
  ; Podemos declarar variáveis de duas formas, com (def) e com (let)
  (def x (atom 20))

  ; Utilizando a função let, podemos criar variáveis que funcionarão
  ; dentro do escopo da função
  (let [y 3
        z 0.4]
    (+ @x y z w)))
(def mapa
  ; Para criar um mapa (ou vetor) em clojure, utilizamos [], separando cada item do mapa com um new line
  ; Para criar objetos, usamos o template {:atributo valor :atributo2 valor2}
  [{:nome "atr1" :valor 1}
   {:nome "atr2" :valor 2}
   {:nome "atr3" :valor 3.33}])

(defn atributo-mapa
  [mapa]
  (map :nome mapa)
  ; A função map funciona recebe dois parâmetros, o nome de um atributo e um mapa,
  ; e retorna o valor desse atributo para cada posição no mapa.
  ; É uma espécie de "for each"
  )

(defn acessar-mapa
  [mapa pos]
  (get mapa pos)
  ; A função get recebe um mapa e uma posição, e retorna o valor dessa posição
  ; no mapa. A primeira posição de um mapa em Clojure é 0  
  )

(defn while-loop
  [valor]
  (def i (atom 1)) ; Declaração de uma variável i

  ; A função while recebe uma condicional e algo para ser executado
  (while (<= @i valor)
    (do ; A função do vai executar em sequência tudo dentro do seu escopo
      (print @i) ; Print do valor da variável i
      (print " ")
      (swap! i inc) ; Incrementação da variável i
      )))

; Para executar programas Clojure, utilizamos o programa Leiningen
; Dentro da pasta do projeto, execute "lein run"
; O que será executado deve estar dentro da função -main
(defn -main
  [& args] ; Argumentos inline
  (println (funcao "Trabalho LP"))
  (print "Soma: ") (println (soma 1 2))
  (println "Condicionais 1: ")
  (println (condicionais-1 1))
  (println (condicionais-1 -1))
  (println "Condicionais 2: ")
  (println (condicionais-2 1))
  (println (condicionais-2 2))
  (println (condicionais-2 3))
  (print "Variáveis: ") (println (variavel 100))
  (print "Mapa: ") (println mapa)
  (print "Posição 1 do mapa: ") (println (acessar-mapa mapa 1))
  (print "Atributos \"nome\" no mapa: ") (println (atributo-mapa mapa))
  (print "While loop: ");
  (while-loop 5))