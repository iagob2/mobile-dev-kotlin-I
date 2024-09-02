package com.example.consultarcapapplication.dao

import com.example.consultarcapapplication.model.Endereco
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

// Classe responsável por consumir a API de CEP e retornar um objeto Endereco.
class ConsumirApi {

    // Cria uma instância do OkHttpClient, que será usada para fazer as requisições HTTP.
    private val client = OkHttpClient()

    // Objeto estático para armazenar o endereço consultado. Serve como cache para evitar chamadas repetidas à API.
    companion object {
        private var enderecoCache: Endereco? = null
    }

    // Função que recebe um CEP e retorna um objeto Endereco correspondente.
    fun lerEnderecoPorCep(cep: String): Endereco {

        // Verifica se o endereço já foi cacheado. Se sim, retorna o endereço cacheado.
        enderecoCache?.let { return it }

        // Monta a URL da API usando o CEP fornecido. A API utilizada é a ViaCEP.
        val url = "https://viacep.com.br/ws/$cep/json/"

        // Cria uma requisição HTTP GET usando a URL construída.
        val request = Request.Builder().url(url).build()

        // Exibe a URL gerada no console para fins de depuração.
        println("URL: $url")

        // Tenta executar a requisição e processar a resposta.
        return try {
            val response = client.newCall(request).execute()

            // Verifica se a resposta HTTP foi bem-sucedida (código 200 OK).
            if (!response.isSuccessful) throw RuntimeException("Código inesperado: $response")

            // Extrai o corpo da resposta como uma string.
            val responseBody = response.body?.string() ?: throw RuntimeException("Corpo da resposta é nulo")

            // Converte a string JSON em um objeto JSONObject.
            val json = JSONObject(responseBody)

            // Verifica se o JSON contém um erro, o que indica que o CEP é inválido.
            if (json.has("erro")) {
                throw RuntimeException("CEP inválido")
            }

            // Extrai os dados de logradouro, bairro, cidade e estado do JSON,
            // utilizando valores padrão ("Não disponível") caso as chaves não estejam presentes.
            val logradouro = json.optString("logradouro", "Não disponível")
            val bairro = json.optString("bairro", "Não disponível")
            val cidade = json.optString("localidade", "Não disponível")
            val estado = json.optString("uf", "Não disponível")

            // Cria um objeto Endereco com os dados extraídos.
            enderecoCache = Endereco(logradouro, bairro, cidade, estado)

            // Retorna o endereço criado e armazenado no cache.
            return enderecoCache!!
        } catch (e: Exception) {
            // Caso ocorra alguma exceção durante a execução da requisição ou processamento da resposta,
            // uma RuntimeException é lançada com uma mensagem de erro específica.
            throw RuntimeException("Erro ao consultar o CEP: ${e.message}")
        }
    }
}
