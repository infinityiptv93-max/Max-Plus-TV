# Minha IPTV — protótipo Android

Este projeto é a primeira base visual do aplicativo Minha IPTV, com interface em português, tema vermelho/preto, navegação por categorias e lista demonstrativa de canais.

## O que esta versão já contém
- Projeto Android nativo em Kotlin + Jetpack Compose.
- Interface inicial responsiva para telas de TV e dispositivos Android.
- Navegação por categorias e lista demonstrativa.
- Permissão de internet preparada para futuras integrações.

## O que ainda não está implementado
- Reprodução de vídeo.
- Importação real de listas M3U.
- Login Xtream Codes.
- EPG, favoritos persistentes e catálogo remoto.
- Logotipos e metadados reais de canais/filmes.

Os nomes exibidos na lista são dados demonstrativos. Use apenas URLs e conteúdo para os quais você tenha autorização de distribuição/acesso.

## Como abrir e compilar
1. Instale o Android Studio em um computador.
2. Descompacte o arquivo ZIP.
3. No Android Studio, escolha **Open** e selecione a pasta `MinhaIPTV_Android`.
4. Aguarde a sincronização do Gradle.
5. Se solicitado, instale o Android SDK 35.
6. Use **Build > Build APK(s)**.
7. O APK de depuração normalmente fica em `app/build/outputs/apk/debug/app-debug.apk`.

## Próxima etapa
Integrar um player Android (por exemplo, AndroidX Media3/ExoPlayer), importação M3U e/ou autenticação Xtream, além de testar a navegação em Android TV/Fire TV.
