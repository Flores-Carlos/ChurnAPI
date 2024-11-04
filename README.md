# ChurnAPI - Sprint 4

Repositório destinado à aplicação **ChurnAPI** da **ChurnAnalytics**, desenvolvida para auxiliar no desenvolvimento e manutenção de uma Inteligência Artificial (IA) voltada à previsão de churn (evasão de clientes). Este projeto faz parte do **Challenge FIAP 2024**, realizado em parceria com a **Plusoft**. O objetivo principal do projeto é criar uma solução capaz de prever churn e, com isso, auxiliar a empresa no direcionamento e melhoria do relacionamento com seus próprios clientes.

## Membros do Grupo

- **Carlos Gabriel de Freitas Flores Ferreira** - RM97528
- **Kaique Gabriel Toschi** - RM551165
- **Macirander Souza de Miranda Filho** - RM551416
- **Munir Jamil Mahmoud Ayoub** - RM550893
- **Vinicius Ariel Monteiro Teixeira** - RM98839

---

## Descrição do Projeto

A ChurnAPI é uma aplicação desenvolvida em **Java** com **Spring Boot**, projetada para gerenciar e manipular dados que serão utilizados no treinamento e execução de um modelo de IA para previsão de churn. Este sistema inclui funcionalidades de autenticação, mensageria, monitoramento, e integração com um endpoint de IA. A estrutura segue a arquitetura **MVC** (Model-View-Controller) para facilitar a organização e manutenção do código.

### Funcionalidades Implementadas na Sprint 4

Nesta sprint, focamos em aprimorar o sistema com as seguintes implementações:

1. **Segurança com Spring Security**:
   - Configuramos autenticação e autorização, incluindo diferentes perfis de usuário (admin e user).
   - Incluímos uma página de login personalizada e a proteção de rotas sensíveis.

2. **Internacionalização (i18n)**:
   - Implementamos internacionalização para suportar os idiomas inglês e português.
   - Configuramos o sistema para detectar automaticamente o idioma com base na localização ou configuração do navegador do usuário.

3. **Mensageria com RabbitMQ**:
   - Adicionamos mensageria com RabbitMQ, permitindo o envio e recebimento de mensagens através de uma fila chamada `churnQueue`.
   - Implementamos um produtor para enviar mensagens e um consumidor para recebê-las e processá-las de forma assíncrona.

4. **Monitoramento com Spring Boot Actuator**:
   - Configuramos o Spring Boot Actuator para monitoramento em tempo real da saúde e do desempenho da aplicação.
   - Disponibilizamos endpoints de monitoramento, como `/actuator/health` para verificar a saúde do sistema e `/actuator/metrics` para métricas detalhadas de uso de recursos.

5. **Integração com IA (Inteligência Artificial)**:
   - Implementamos o caminho para integração com um modelo de IA externo para predição de churn.
   - Embora o modelo final de predição de churn não esteja implementado, configuramos o `AIService` para enviar dados a um endpoint de IA externo (`/api/ai/predict`). Essa estrutura facilita futuras integrações com um modelo de IA já treinado.

---

## Pré-Requisitos

- **RabbitMQ** instalado e em execução
  - Pode ser instalado localmente ou executado via Docker:
    ```bash
    docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
    ```

### Passos para Executar a Aplicação

1. **Clonar o Repositório**:
   - Clone este repositório em sua máquina e abra o projeto na sua IDE de preferência.
   - Certifique-se de abrir especificamente a pasta `churn` do repositório.

2. **Configurar e Iniciar o RabbitMQ**:
   - Certifique-se de que o RabbitMQ está rodando localmente. O projeto utiliza a fila `churnQueue` para enviar e receber mensagens.

3. **Executar a Aplicação**:
   - Na sua IDE, execute a classe principal (`ChurnApiApplication.java`), que inicializa a aplicação.
   - Acesse `http://localhost:8080` no navegador para interagir com a aplicação.

4. **Acessar Endpoints de Monitoramento**:
   - Para monitorar a aplicação, utilize os endpoints do Actuator:
     - `http://localhost:8080/actuator/health` - Verifica a saúde do sistema.
     - `http://localhost:8080/actuator/metrics` - Exibe métricas de desempenho.

---

## Observações sobre a Implementação de IA

A integração direta com um modelo de IA para predição ainda não foi finalizada. No entanto, o sistema está configurado para se comunicar com um endpoint de IA. Isso significa que, quando o modelo de IA estiver disponível, basta conectá-lo ao serviço para que o sistema passe a gerar predições de churn automaticamente.

## Observações sobre o Banco de Dados e Limitações

Durante os testes, encontramos um problema com o **banco de dados Oracle**: ele tem um **limite de sessões simultâneas**. Quando esse limite estoura, acontece um erro de conexão que acabou impactando nos nossos testes.

Então, só um aviso de que isso pode afetar os testes do professor também, caso várias sessões tentem acessar o banco ao mesmo tempo ou testes sejam realizados com intervalos muito curtos entre eles.

---

## Link para Apresentação

[Vídeo de Apresentação da Sprint 4](https://youtu.be/LnWLZwimmeM)

Toda a documentação detalhada também pode ser encontrada na pasta `documentos` do repositório ou neste `README.md`.

---