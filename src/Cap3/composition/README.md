<h1>Capítulo 4 - Item 18: Prefira a composição à herança</h1>

<h3>Classe InstrumentedSetWrong</h3>
Este exemplo estende a classe HashSet e sobrescreve os métodos add e addAll, incluindo um contador 
que deverá retornar a quantidade de itens da coleção.
No método addAll, é feita a soma dos itens da coleção que está sendo incluída. Porém quando é chamado
o método super.addAll (classe HashSet), ela aciona o método add, que foi sobrescrito e também incrementa
o contador. Dessa forma o contador é duplamente incrementado, retornando a quantidade de itens incorreto
da coleção.

<h3>Classe InstrumentedSetTest</h3>
- FowardingSet implementa a classe Set, e cria um campo privado que referencia a interface Set.
Esse design é chamado de composição, porque a classe existente se torna um componente da nova classe.
Nesta classe são criados os métodos de encaminhamento, que são nada mais que métodos que encapsulam a 
chamada dos métodos da instância privada Set. Caso sejam adicionados novos métodos na classe
existente Set, não impactará a classe nova.

- IntrumentedSet estende a FowardingSet e pode ser utilizada para qualquer implementação de Set, 
como HashSet, LinkedHashSet, TreeSet. Ela também é conhecido como classe wrapper. Nela, pode ser implementado
o contador, e não existe a duplicidade de incremento pois não foi realizado sobrescrita do método addAll.

- InstrumentedSetTest implementa exemplo de utilização da classe InstrumentedSet, chamando os métodos
add e addAll, sem que ocorra duplicidade no contados.
