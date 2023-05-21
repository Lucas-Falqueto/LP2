
const App = (function () {
    const btnAudio = document.getElementById('player');
    let _gridEl = null;
    let _btnStart = null;
    let _pokemons = [];
    let _acertos = [];
    let _selecao = {
        poke1: null,
        poke2: null
    };

    // cria uma abstração de sintaxe mais curta para o método fetch() e response.json()
    const _meuFetch = (url, options) =>
        new Promise((resolve, rejeita) =>
            fetch(url, options || {})
                .then(resposta =>
                    resposta
                        .json()
                        .then(dados => resolve(dados))
                        .catch(erro => rejeita(erro))
                )
                .catch(erro => rejeita(erro))
        );

    const _preencheGrid = (indexes, mostrarTudo) => {
        indexes = indexes || [];
        mostrarTudo = mostrarTudo || false;
        let grid = "";
        for (let [index, pokemon] of _pokemons.entries()) {
            let _style =
                mostrarTudo ||
                    indexes.indexOf(index) > -1 ||
                    _acertos.indexOf(index) > -1
                    ? `style="background-image: url(${pokemon.sprites.front_default})"`
                    : "";
            grid += `<div class="poke-card" data-index="${index}" ${_style}></div>`;
            _gridEl.innerHTML = grid;
        }
    };

    const _embaralhar = array => {
        let indiceAtual = array.length;
        let valorTemporario;
        let indiceAleatorio;

        while (0 !== indiceAtual) {
            indiceAleatorio = Math.floor(Math.random() * indiceAtual);
            indiceAtual -= 1;

            valorTemporario = array[indiceAtual];
            array[indiceAtual] = array[indiceAleatorio];
            array[indiceAleatorio] = valorTemporario;
        }

        return array;
    };

    const _zerarSelecoes = () => {
        _selecao = { poke1: null, poke2: null };
        _preencheGrid();
    };

    const _salvaAcertos = () => {
        _acertos = [..._acertos, _selecao.poke1, _selecao.poke2];
        _zerarSelecoes();
    };

    const _onCardClick = e => {
        btnAudio.setAttribute('src', './songs/rotatecard.mp3')
        btnAudio.play()
        if (e.target.className == "poke-card") {

            let index = e.target.dataset.index;
            if (_selecao.poke1 === null) {
                _selecao.poke1 = +index;
            } else if (_selecao.poke2 === null) {
                _selecao.poke2 = +index;
            }
            _preencheGrid(
                _selecao.poke2 !== null
                    ? [_selecao.poke1, _selecao.poke2]
                    : [_selecao.poke1]
            );

            if (_pokemons[_selecao.poke1].id != _pokemons[_selecao.poke2].id) {
                setTimeout(() => _zerarSelecoes(), 1000);
            } else {
                btnAudio.setAttribute('src', './songs/win.mp3')
                btnAudio.play()
                _salvaAcertos();
            }
        }
    };

    const _randr = () => {
        let ids = [];
        while (ids.length < 10) {
            ids.push(Math.floor(Math.random() * 806 + 1));
        }
        return ids;
    };

    const _start = () => {
        _pokemons = [];
        _acertos = [];
        let promises = [];

        for (let id of _randr()) {
            promises.push(_meuFetch(`https://pokeapi.co/api/v2/pokemon/${id}`));
        }

        Promise.all(promises).then(pokes => {
            _pokemons = _embaralhar([...pokes, ...pokes]);
            _preencheGrid([], true);
            setTimeout(() => _preencheGrid(), 3000);
        });

    };

    const _init = () => {
        _gridEl = document.querySelector("#grid");
        _btnStart = document.querySelector("#start");

        _gridEl.addEventListener("click", _onCardClick);
        _btnStart.addEventListener("click", _start);

        _start();
    };

    return {
        init: _init
    }

})();

document.addEventListener('DOMContentLoaded', () => {
    App.init();
});