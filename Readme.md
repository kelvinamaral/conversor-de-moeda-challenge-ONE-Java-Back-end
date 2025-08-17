# 💱 Conversor de Moedas

Bem-vindo ao **Conversor de Moedas**, um projeto em **Java** desenvolvido para converter valores entre diferentes moedas utilizando **taxas de câmbio em tempo real**.  
A aplicação roda no **console**, oferecendo uma experiência simples, rápida e prática.

---

## 🚀 Funcionalidades

- **Taxas de câmbio em tempo real**: obtidas dinamicamente de uma API, sempre atualizadas.
- **Menu interativo**: escolha entre **6 opções pré-definidas** de conversão.
- **Execução via console**: não exige interface gráfica, leve e fácil de rodar.
- **Tratamento de erros**: entradas inválidas e falhas de conexão são tratadas.

---

## 🛠️ Tecnologias Utilizadas

- **Java** – Linguagem principal.
- **API de Taxas de Câmbio** – Fonte dos dados atualizados.
- **Maven/Gradle** – Gerenciamento de dependências (caso necessário).
- **Biblioteca JSON** (ex.: Gson, Jackson) – Para análise da resposta da API.

---

## 📖 Como Usar

1. **Configurar chave da API**
    - O projeto utiliza uma chave para acessar as taxas de câmbio.
    - Configure uma variável de ambiente chamada **`EXCHANGE_RATE_API_KEY`** com sua chave de API.
    - Exemplo (Linux/Mac):
      ```bash
      export EXCHANGE_RATE_API_KEY=sua_chave_aqui
      ```
      Exemplo (Windows PowerShell):
      ```powershell
      setx EXCHANGE_RATE_API_KEY "sua_chave_aqui"
      ```

2. **Clonar o repositório**
   ```bash
   git clone [link-do-seu-repositorio]


3. Abrir o projeto em sua IDE (IntelliJ, Eclipse, VS Code etc.).
4. Instalar dependências (a IDE normalmente faz isso automaticamente).
5. Executar a classe principal

 - Arquivo: Principal.java

 - O programa será iniciado diretamente no console.

## 📈 Conversões Disponíveis

- Dólar (USD) ➝ Peso Argentino (ARS)

- Peso Argentino (ARS) ➝ Dólar (USD)

- Dólar (USD) ➝ Real Brasileiro (BRL)

- Real Brasileiro (BRL) ➝ Dólar (USD)

- Dólar (USD) ➝ Peso Colombiano (COP)

- Peso Colombiano (COP) ➝ Dólar (USD)

0. Sair do sistema

# 🙏 Obrigado!