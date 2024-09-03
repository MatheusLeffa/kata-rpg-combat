RPG Combat Kata
================
Kata para praticar programação POO Java

Source: [https://github.com/ardalis/kata-catalog](https://github.com/ardalis/kata-catalog)

# Background #

Este é um kata divertido em que o programador constrói regras de combate simples, como em um RPG (RPG). É implementado como uma sequência de iterações. O domínio não inclui um mapa ou qualquer outra habilidade do personagem além de sua capacidade de causar danos e curar uns aos outros.

# Instruções #

1. Conclua cada iteração antes de ler a próxima.

1. É recomendado que você execute este kata com um parceiro e enquanto escreve testes.

## Iteração 1 ##

1. Todos os Personagens, quando criados, possuem:
    - Saúde, a partir de 1000
    - Nível, começando em 1
    - Pode estar Vivo ou Morto, começando Vivo (Vivo pode ser verdadeiro/falso)

1. Personagens podem causar danos aos personagens.
    - O dano é subtraído da Saúde
    - Quando o dano recebido excede a Saúde atual, a Saúde se torna 0 e o personagem morre

1. Um personagem pode curar um personagem.
    - Personagens mortos não podem ser curados
    - A cura não pode aumentar a saúde acima de 1000

## Iteração 2 ##

1. Um personagem não pode causar dano a si mesmo.

1. Um personagem só pode curar a si mesmo.

1. Ao causar dano:
    - Se o alvo estiver 5 ou mais níveis acima do atacante, o dano é reduzido em 50%
    - Se o alvo estiver 5 ou mais níveis abaixo do atacante, o dano aumenta em 50%

## Iteração 3 ##

1. Os personagens têm um alcance máximo de ataque.

1. Lutadores *corpo a corpo* têm um alcance de 2 metros.

1. Os caças de *alcance* têm um alcance de 20 metros.

1. Os personagens devem estar dentro do alcance para causar dano a um alvo.

## Retrospectiva ##

- Você está acompanhando os requisitos? Alguma iteração foi um grande desafio?
- Você se sente bem com seu design? É escalável e facilmente adaptável a novos requisitos?
- Está tudo testado? Você está confiante em seu código?


## Iteração 4 ##

1. Os personagens podem pertencer a uma ou mais Facções.
    - Personagens recém-criados não pertencem a nenhuma facção.

1. Um personagem pode ingressar ou sair de uma ou mais facções.

1. Jogadores pertencentes à mesma Facção são considerados Aliados.

1. Os aliados não podem causar danos uns aos outros.

1. Aliados podem curar uns aos outros.

## Iteração 5 ##

1. Os personagens podem danificar *coisas* (adereços) que não sejam do personagem.
    - Qualquer coisa que tenha Saúde pode ser um alvo
    - Essas coisas não podem ser curadas e não causam danos
    - Essas coisas não pertencem a Facções; eles são neutros
    - Quando reduzido a 0 de Vida, as coisas são *Destruídas*
    - Por exemplo, você pode criar uma Árvore com 2.000 de Saúde

## Retrospectiva ##

- Que problemas você encontrou?
- O que você aprendeu? Alguma nova técnica ou padrão?
- Compartilhe seu design com outras pessoas e obtenha feedback sobre diferentes abordagens.

# Resources #

- Original Source: http://www.slideshare.net/DanielOjedaLoisel/rpg-combat-kata
