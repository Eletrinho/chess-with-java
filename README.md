# Projeto de Xadrez - Aplicação de Console em Java

Este projeto é uma implementação baseada em console de um jogo de xadrez usando Java. Ele permite que dois jogadores joguem um contra o outro, seguindo as regras padrão do xadrez.

## Recursos

- **Jogabilidade para dois jogadores**: Jogue contra um amigo no mesmo computador.
- **Regras padrão do xadrez**: O jogo aplica todas as regras padrão do xadrez, incluindo:
  - Movimentos legais para cada peça.
  - Condições de xeque e xeque-mate.
  - Movimentos especiais como roque e en passant.
  - Promoção de peões.
- **Interface de console**: O jogo é jogado no console, com uma interface simples e intuitiva.
- **Tratamento de erros**: O jogo lida com entradas inválidas e movimentos ilegais, fornecendo mensagens de erro claras.
- **Sistema de logging**: Ao final da partida é gerado um arquivo `.csv` com o histórico de movimentos feitos.

## Como Jogar

1. **Compilar e executar**: Compile e execute o arquivo `Program.java`.
2. **Inserir movimentos**: O jogo solicitará que o jogador atual insira seu movimento.
3. **Formato do movimento**: Insira os movimentos usando o seguinte formato: `posição_origem posição_destino`. Por exemplo, para mover o peão de E2 para E4, insira `e2` depois `e4`.
4. **Progresso do jogo**: O jogo exibirá o tabuleiro atualizado após cada movimento.
5. **Fim do jogo**: O jogo termina quando ocorre um xeque-mate ou empate.

## Estrutura do Código

O projeto está estruturado nos seguintes pacotes:

- **application**: Contém a classe principal da aplicação (`Program.java`) e a lógica da interface do usuário (`UI.java`).
- **boardgame**: Contém a lógica central do jogo, incluindo classes para o tabuleiro, peças e posições.
- **chess**: Contém a lógica específica do xadrez, incluindo classes para peças de xadrez, a partida de xadrez e exceções específicas do xadrez.

## Melhorias Futuras

- **Oponente IA**: Implementar um oponente IA para jogar contra.
- **~~Salvar~~ e carregar jogos**: ~~Permitir que os jogadores salvem~~ e carreguem seus jogos.
- **Histórico de movimentos**: Exibir um histórico dos movimentos feitos durante o jogo.

## Contribuindo

Contribuições para este projeto são bem-vindas. Sinta-se à vontade para fazer um fork do repositório e enviar pull requests para qualquer correção de bugs, melhorias ou novos recursos.

## Reconhecimentos

Este projeto foi desenvolvido como parte de um [curso de programação em Java](https://www.udemy.com/course/java-curso-completo/).
