// Representa o tabuleiro do jogo
let board = ['', '', '', '', '', '', '', '', ''];

// Define o jogador atual (X ou O)
let currentPlayer = 'X';

// Verifica se o jogo já terminou
let gameEnded = false;

// Obtém todas as células do tabuleiro
const cells = document.querySelectorAll('.cell');

// Adiciona um ouvinte de clique a cada célula
cells.forEach(cell => {
    cell.addEventListener('click', () => {
        if (!gameEnded && board[cell.dataset.index] === '') {
            // Atualiza a célula com o símbolo do jogador atual
            board[cell.dataset.index] = currentPlayer;
            cell.innerText = currentPlayer;

            // Verifica se o jogador atual venceu
            if (checkWinner()) {
                document.getElementById('result').innerText = `Jogador ${currentPlayer} venceu!`;
                gameEnded = true;
            } else if (board.every(cell => cell !== '')) {
                // Verifica se o jogo é um empate
                document.getElementById('result').innerText = 'Empate!';
                gameEnded = true;
            } else {
                // Troca para o próximo jogador
                currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
            }
        }
    });
});

// Função para verificar se um jogador venceu
function checkWinner() {
    const winPatterns = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8], // Linhas
        [0, 3, 6], [1, 4, 7], [2, 5, 8], // Colunas
        [0, 4, 8], [2, 4, 6]              // Diagonais
    ];

    return winPatterns.some(pattern => {
        const [a, b, c] = pattern;
        return board[a] !== '' && board[a] === board[b] && board[b] === board[c];
    });
}

// Função para reiniciar o jogo
function resetGame() {
    board = ['', '', '', '', '', '', '', '', ''];
    currentPlayer = 'X';
    gameEnded = false;
    document.getElementById('result').innerText = '';
    cells.forEach(cell => {
        cell.innerText = '';
    });
}
