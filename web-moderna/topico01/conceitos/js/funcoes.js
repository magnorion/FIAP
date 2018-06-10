$(document).ready(function() {
  var lista = ['JavaScript', 'jQuery', 'Java', 'JPA'];

  $.each(lista, function(i, curso) {
    $('#curso').append($('<option>', { text:curso, value:i }));
  });
})

function exibir(e) {
  e.preventDefault();
  var nome = document.querySelector('#nome').value,
  idade = document.querySelector('#idade').value,
  curso = document.querySelector('#curso').value,
  resposta = "";

  if (idade >= 18) {
    resposta = 'O aluno tem 18 anos';
  }

  resposta += "\nNome: " + nome + ", idade: " + idade + ", curso: "+curso;
  console.log(resposta);
}
var btn = document.querySelector('#btnEnviar');
btn.addEventListener('click', exibir);
