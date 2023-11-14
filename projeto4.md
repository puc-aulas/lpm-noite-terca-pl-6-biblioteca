
**Pontifícia Universidade Católica de Minas Gerais**
**Bacharelado em Engenharia de Software – Unidade Praça da Liberdade**
**Laboratório de Programação Modular**
**Prof.** Luiz Henrique da Costa Silva **– Semestre** 2º/2023
**Projeto Prático 4 – Valor:** 30 pontos

Este documento constitui o enunciado do Projeto Prático 4 de Laboratório de Programação
Modular. O propósito do projeto é exercitar os seguintes conteúdos: princípios SOLID, tratamento
de exceções, padrões de projeto e interface gráﬁca com o usuário. O repositório do projeto 3 será
reaproveitado para o projeto 4.

**Título do projeto:** Sistema de Gerenciamento de Biblioteca 2.0
**Período de acompanhamento:** 07/11 a 28/11

Os usuários do sistema de gerenciamento de biblioteca anterior se queixam das mensagens
recebidas ao tentarem pegar itens emprestados. Simplesmente surge uma mensagem de erro que
não são capazes de traduzir. As possibilidades são as seguintes: 
- (a) tiver algum livro em atraso
- (b) já tiver 3 livros em sua posse
- (c) o livro for o último exemplar disponível  
- (d) ele já possuir umexemplar do que está tentando pegar (novo).

Além disso, alguns estudantes relataram tédio na seleção de novos itens e sugeriram um sistema de recomendação. 
Adicionalmente, os funcionários da biblioteca se queixam do menu, dizem que a produtividade é baixa porque a
interface é ruim. Apesar desses problemas, o software tem suprido as necessidades dessa
biblioteca custando muito pouco, razão de outras bibliotecas se interessarem por ele. No entanto,
o desenvolvimento do software não envolveu práticas tão boas de desenvolvimento e queremos corrigir isso para comercializá-lo.

**Requisitos:**

a) Não deve ser possível pegar emprestado exemplares repetidos;

b) Sistema de recomendação: o sistema deverá conter uma funcionalidade de recomendação de
livros que seja relacionada com os interesses dos usuários. Para aferição dos interesses do
usuário devem ser veriﬁcadas:
as declarações do usuário sobre categorias de interesse;
o histórico do usuário na biblioteca;
o curso do aluno;

O sistema deve recomendar pelo menos 3 itens que, de acordo com a lógica deﬁnida, se
relacionam com os interesses do usuário. Os itens recomendados devem ser ranqueados do
mais interessante para o menos interessante para o usuário (não importa se emprestáveis ou
não).

c) Interface gráﬁca com o usuário: deverá haver uma interface gráﬁca para os cadastros de
usuários e itens da biblioteca.

d) As situações narradas no enunciado, em que o estudante não pode efetuar um empréstimo,
devem ter tratamentos de erro com mensagens condizentes com o erro (utilizar blocos
try-catch).

e) Deve haver uma única instância da classe Biblioteca e não deve ser possível instanciar outra
(padrão de projeto: singleton);

f) A criação de itens de biblioteca deve ser feita por meio de métodos factory (padrão de projeto:
factory method);

g) A funcionalidade do requisito b) exige que a classe usuário possua atributos “curso” e
“categorias de interesse”. Para essa funcionalidade deve ser implementada uma classe
adaptada (padrão de projeto: adapter).

h) O desenvolvimento deve atender aos princípios SOLID;

**Entregas:**

21/11/2023: Readme.md atualizado com informações do novo sistema de gestão de biblioteca,

além dos requisitos a) e b) funcionando;

27/11/2023: Requisito funcional c) e requisitos não-funcionais;

**Critérios de pontuação:**

- Github, documentação e atendimento aos princípios da programação modular: 15 pontos

- Implementação dos requisitos funcionais: 15 pontos
