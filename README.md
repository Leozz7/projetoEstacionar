# Sistema de Gerenciamento de Estacionamento

## 📝 Descrição
Este projeto é um sistema de gerenciamento de estacionamento desenvolvido em Java que permite controlar a entrada, saída e cadastro de veículos, além de oferecer funcionalidades para consulta e alteração de dados.

## ✨ Funcionalidades Principais

- **Cadastro de veículos**: Registra novos veículos com dados completos
- **Registro de saída**: Marca a saída de veículos com horário
- **Alteração de dados**: Permite editar informações cadastradas
- **Consultas**:
  - Listagem completa de todos os veículos
  - Pesquisa por CPF ou placa
- **Validação de dados**: Verifica formato de CPF, placa e outros campos

## 🛠️ Tecnologias Utilizadas

- **Java** (linguagem principal)
- **MySQL** (banco de dados para armazenamento)
- **JDBC** (conexão com o banco de dados)
- **java.text.SimpleDateFormat** (para formatação de datas e horários)

## 🗃️ Estrutura do Banco de Dados

O sistema utiliza uma tabela principal:

**CARROS** - Armazena todos os veículos estacionados
- Campos: 
  - `id` (INT, auto incremento)
  - `nome` (VARCHAR, nome do proprietário)
  - `cpf` (VARCHAR, formato 000.000.000-00)
  - `carro` (VARCHAR, modelo do veículo)
  - `placa` (VARCHAR, formato XXX0000)
  - `entrada` (VARCHAR, data e hora de entrada)
  - `saida` (VARCHAR, data e hora de saída)

## ▶️ Como Executar

1. Certifique-se de ter o MySQL instalado e configurado
2. Crie um banco de dados chamado `estacionamento`
3. Importe a estrutura da tabela CARROS (arquivo SQL fornecido)
4. Configure as credenciais do banco na classe `Conexao`
5. Execute a classe `Main`

## 📋 Fluxo do Sistema

1. **Menu principal** com 5 opções:
   - Adicionar carro
   - Retirar carro
   - Alterar um dado
   - Exibir carros cadastrados
   - Sair

2. **Validações automáticas**:
   - Formato de CPF (000.000.000-00)
   - Formato de placa (XXX0000)
   - Campos obrigatórios

3. **Registro automático** de data e hora:
   - Na entrada do veículo
   - Na saída do veículo

## 📂 Estrutura do Projeto

```
src/
├── com/
│   └── projeto/
│       └── Estacionamento/
│           ├── Conexao.java         # Gerencia conexão com o BD
│           ├── Main.java            # Classe principal com menu interativo
│           ├── UsuarioDAO.java      # Operações de banco de dados
├── entity/
│   └── Usuario.java                 # Entidade que representa o veículo/proprietário
```

## ⚙️ Funcionalidades Detalhadas

### 1. Adicionar Carro
- Coleta: nome, CPF, modelo e placa do veículo
- Valida todos os campos
- Registra automaticamente a data/hora de entrada
- Armazena no banco de dados

### 2. Retirar Carro
- Localiza veículo pela placa
- Registra automaticamente a data/hora de saída
- Atualiza o banco de dados

### 3. Alterar Dados
- Permite alterar:
  - Nome do proprietário
  - CPF
  - Modelo do carro
  - Placa
- Mantém histórico de entrada/saída

### 4. Consultas
- **Exibir todos**: Lista completa ordenada por ID
- **Pesquisar**: Filtra por CPF ou placa

## 📌 Validações Implementadas

1. **CPF**:
   - Formato fixo: 000.000.000-00
   - 14 caracteres (incluindo pontos e traço)

2. **Placa**:
   - Formato: 3 letras + 4 números (XXX0000)
   - Sem hífen ou caracteres especiais

3. **Nome**:
   - Não pode ser vazio
