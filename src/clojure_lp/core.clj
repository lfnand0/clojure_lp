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

  ; Cond: (cond (condição 1) retorno1 (condição 2) retorno2 ... :else retornoN)
  ; Podemos colocar quantas condições forem necessárias
  ; O :else é utilizado para os casos no qual todas as condicionais são false
  [valor]
  (cond
    (= valor 1) "Valor é 1"
    (= valor 2) "Valor é 2"
    :else "Valor não é 1 nem 2"))

(defn condicionais-3
  [valor]
  ; Condicionais: switch-case

  ; Case: (case x valor1 retorno1 valor2 retorno2 ... default)
  ; Caso o valor de x for igual a valor1, a função case retorna retorno1, se não 
  ; continua checando até achar algum valor igual ou, caso não encontre, retorna 
  ; o default (opcional)
  (case valor
    1 "Valor é 1"
    2 "Valor é 2"
    "Valor não é 1 nem 2"))


(defn variavel
  [w]
  ; Podemos declarar variáveis de duas formas, com (def) e com (let)
  (def x (atom 20))

  ; Utilizando a função let, podemos criar variáveis que funcionarão
  ; dentro do escopo da função
  (let [y 3
        z 0.4]
    (+ @x y z w)))

; ESTRUTURAS DE DADOS
; (1 2 3 4 5)                 | List
; ["a" "b" "c" "d" "e"]       | Vector
; {:nome "Nome" :valor 123}   | Map
; #{5 1 4 2 3}                | Set

(def vetor
  ; Para criar um vetor  em clojure, utilizamos [], separando cada item do vetor com um new line
  ; Para criar mapas, usamos o padrão {:atributo valor :atributo2 valor2}
  [{:nome "atr1" :valor 1}
   {:nome "atr2" :valor 2}
   {:nome "atr3" :valor 3.33}])

(defn atributo-vetor
  [vetor]
  (map :nome vetor)
  ; A função map funciona recebe dois parâmetros, o nome de um atributo e um vetor,
  ; e retorna o valor desse atributo para cada mapa no vetor.
  ; É uma espécie de "for each"
  )

(defn acessar-vetor
  [vetor pos]
  (get vetor pos)
  ; A função get recebe um vetor e uma posição, e retorna o valor dessa posição
  ; no vetor. A primeira posição de um vetor em Clojure é 0  
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
  (println "Condicionais 3: ")
  (println (condicionais-3 1))
  (println (condicionais-3 2))
  (println (condicionais-3 3))
  (print "Variáveis: ") (println (variavel 100))
  (print "Vetor: ") (println vetor)
  (print "Posição 1 do vetor: ") (println (acessar-vetor vetor 1))
  (print "Valor do atributo \"nome\" nos mapas do vetor: ") (println (atributo-vetor vetor))
  (print "While loop: ");
  (while-loop 5))
