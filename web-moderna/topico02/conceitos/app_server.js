var http = require('http');
var requisicao = function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/html'});
  res.write('<h1> Text a ser exibido no browser </h1>');
  res.end();
}

var server = http.createServer(requisicao);
var resultado = function () {
  console.log('Servidor rodando');
}

server.listen(3000, resultado);
