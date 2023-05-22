class JogoAdivinhacao {
    constructor(ask) {
        this.perguntas = {
            "Qual é a capital do Brasil?": "brasilia",
            "Qual é o maior planeta do sistema solar?": "jupiter",
            "Qual é o símbolo químico do ouro?": "au",
            "Quem pintou a Mona Lisa?": "da vinci",
            "Qual é o maior mamífero terrestre?": "elefante",
            "Qual é a fórmula química da água?": "h2o",
            "Quem escreveu a peça de teatro 'Romeu e Julieta'?": "shakespeare",
            "Qual é o resultado de 2 + 2?": "4",
        };
        this.pontuacao = 0;
        this.respostaCorreta = "";
    }

    iniciarJogo() {
        const perguntas = Object.keys(this.perguntas);
        const perguntaAleatoria = perguntas[Math.floor(Math.random() * perguntas.length)];
        // console.log(perguntaAleatoria)
        ask.innerHTML = perguntaAleatoria;
        this.respostaCorreta = this.perguntas[perguntaAleatoria];

        // const respostaUsuario = prompt(perguntaAleatoria);




    }

    async verificaResposta() {
        const resp = document.querySelector(".resp")
        const audio = document.querySelector('audio')
        if (resp.value.toLowerCase() === this.respostaCorreta) {
            this.pontuacao++;
            alert("Resposta correta! Pontuação: " + this.pontuacao);
            this.iniciarJogo();
        } else {

            audio.setAttribute('src', 'erro.mp3')
            await audio.play()
            alert("Resposta incorreta! Pontuação: " + this.pontuacao);
        }
        resp.value = ''
    }
}

const jogo = new JogoAdivinhacao();
const ask = document.querySelector(".ask")

document.onload = jogo.iniciarJogo(ask);

document.querySelector('.btn').addEventListener('click', (e) => {
    jogo.verificaResposta()
})
document.addEventListener('keyup', e => {
    if (e.key === "Enter")
        jogo.verificaResposta()
})