# Serviço: Sistema de Pagamento

Atividade desenvolvida para a disciplina de Back-End;

---

## Integrantes da Equipe:

- Bruno de Moraes Supriano;

- Julia Meller Mendes Silva;

- Gustavo Monteiro.

## Casos de Uso:

- Manipular dados de usuário;

- Manipular dados de pagamento.

## Recursos:

- Usuário;

- Pagamento.

---

## Endpoints: USUÁRIO

- ##### Criar usuário (POST)
  
  - URI: POST/usuarios
  
  - Método HTTP: `POST`
  
  - Requisição esperada: dados do usuário (nome, e-mail, senha, etc.)
    
    ```json5
    {
      "ID": "5572" 
      "nome": "fulano de tal"
      "email": "fulano@email.com"
      "login":  "Fulano de tal"
      "senha": "senha123"
      "contato": "+5548999543481"
      "CPF/CNPJ": "12743896415"
    }
    ```
  
  - Erros esperados:
    
    - E-mail já cadastrado (409 Conflict);
    - Login já em uso (409 Conflict);
    - Campos obrigatórios não preenchidos (409 Conflict);
    - Formato inválido de e-mail (400 Bad Request);
    - Formato inválido de CPF/CNPJ. (400 Bad Request).
  
  - Status Codes:
    
    - 201 Created: usuário criado com sucesso.
    - 400 Bad Request: solicitação inválida.

- ##### Obter usuário (GET)
  
  - URI: GET/usuarios/{usuario-id}
  
  - Método HTTP: `GET`
  
  - Requisição esperada: dados do usuário (nome, e-mail, senha, etc.).
    
    ```json5
    {
      "ID": "5572" 
      "nome": "fulano de tal"
      "email": "fulano@email.com"
      "login":  "Fulano de tal"
      "senha": "senha123"
      "contato": "+5548999543481"
      "CPF/CNPJ": "12743896415"
    }
    ```
  
  - Erros esperados:
    
    - Não existe usuário com este ID (404 Not Found).
  
  - Status Codes:
    
    - 200 OK: solicitação bem-sucedida.
    - 404 Not Found: usuário não encontrado.

- ##### Atualizar usuário (PUT ou PATCH)
  
  - URI: PATCH/usuarios/{usuario-id}
  
  - Método HTTP: `PATCH`
  
  - Requisição esperada: Novos dados atualizados
    
    ```json5
    {
      "ID": "5572"
      "nome": "fulano de tal"
      "email": "novoemail@email.com"
      "login":  "Fulano de tal"
      "senha": "novasenha"
      "contato": "novotelefone"
      "CPF/CNPJ": "12743896415"
    }
    ```
  
  - Erros esperados:
    
    - E-mail já cadastrado (409 Conflict);
    - Campos obrigatórios não preenchidos (409 Conflict);
    - Formato inválido de e-mail (400 Bad Request);
    - Formato inválido de CPF/CNPJ (400 Bad Request);
    - E-mail não validado (409 Conflict).
  
  - Status Codes:
    
    - 200 OK: usuário atualizado com sucesso.
    - 400 Bad Request: solicitação inválida.

- ##### Excluir usuário (DELETE)
  
  - URI: DELETE/usuarios/{usuario-id}
  
  - Método HTTP: `DELETE`
  
  - Requisição esperada: Status do usuário deletado
    
    ```json5
     {
      "Id": 5572
       "usuario": "Deletado",
     }
    ```
  
  - Erros esperados:
    
    - Não existe usuário com este ID (404 Not Found).
  
  - Status Codes:
    
    - 204 No Content: usuário excluído com sucesso.
    - 404 Not Found: usuário não encontrado.

---

### Endpoints: PAGAMENTO

- ##### Realizar pagamento (POST)
  
  - URI: POST/pagamentos/{usuario-id}
  
  - Método HTTP: `POST`
  
  - Requisição esperada: valor e método de pagamento
    
    ```json5
    {
      "valor": 50.0,
      "metodo_pagamento": "cartao_credito"
    }
    ```
  
  - Erros esperados:
    
    - Saldo insuficiente (409 Conflict);
    - Campos obrigatórios não preenchidos (409 Conflict).
  
  - Status Codes:
    
    - 201 Created: pagamento realizado com sucesso.
    - 400 Bad Request: solicitação inválida.
    - 402 Payment Required: saldo insuficiente.

- ##### Obter pagamento (GET)
  
  - URI: GET/pagamentos/{usuario-id}/{pagamento-id}
  
  - Método HTTP: `GET`
  
  - Requisição esperada: Valor e método do pagamento
    
    ```json5
    {
      "ID": "5572",
      "valor": 50.0,
      "metodo_pagamento": "cartao_credito"
    }
    ```
  
  - Erros esperados:
    
    - Não existe pagamento com este ID (404 Not Found).
  
  - Status Codes:
    
    - 200 OK: solicitação bem-sucedida.
    - 404 Not Found: pagamento não encontrado.

- ##### Cancelar pagamento (DELETE)
  
  - URI: DELETE/pagamentos/{usuario-id}/{pagamento-id}
  
  - Método HTTP: `DELETE`
  
  - Requisição esperada: Status do pagamento, valor e método
    
    ```json5
    {
      "ID": "5572"
      "status": "Pagamento Cancelado"
      "valor": 80.0,
      "metodo_pagamento": "cartao_debito"
    }
    ```
  
  - Erros esperados:
    
    - Não existe pagamento com este ID (404 Not Found).
  
  - Status Codes:
    
    - 204 No Content: pagamento cancelado com sucesso.
    - 404 Not Found: pagamento não encontrado.
