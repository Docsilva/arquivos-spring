package com.generation.hallo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/")
public class HelloController {
	
	@GetMapping
	public String hello() {
		return "Hello Mercado Livre!!!";
	}

	@GetMapping
	public String hello2() {
		return "✅	MENTALIDADES				\n"
				+ "	RESPONSABILIDADE PESSOAL	AVANÇADO	PROFICIENTE	EM DESENVOLVIMENTO	PRINCIPIANTE\n"
				+ "	Demonstra total responsabilidade por suas ações, comportamentos e resultados de aprendizagem na Generation, incluindo manter sua motivação e engajamento durante todo o programa e participando de todas as sessões sincrônicas.	PONTUA 4/4 DA MÉTRICA	PONTUA 3/4 DA MÉTRICA	PONTUA 2/4 DA MÉTRICA	PONTUA 1/4 DA MÉTRICA (OU MENOS)\n"
				+ "	Conclui todas as responsabilidades e atividades do programa, sem dar desculpas.				\n"
				+ "	Aproveita ao máximo todas as atividades de aprendizagem, incluindo fórum de discussões, atividades com colegas em grupos no zoom e demais atividades onde a pessoa instrutora não está presente.				\n"
				+ "	Comparece aos encontros online nos horários marcados e faz pergunta à pessoa intrutora caso não tenha entendido o conteúdo nas atividades assíncronas e módulos independentes. 				\n"
				+ "	MENTALIDADE DE CRESCIMENTO				\n"
				+ "	Demonstra que tem disposição e vê conceitos novos e desafiadores como uma oportunidade para aprender e crescer.	PONTUA 4/4 DA MÉTRICA	PONTUA 3/4 DA MÉTRICA	PONTUA 2/4 DA MÉTRICA	PONTUA 1/4 DA MÉTRICA (OU MENOS)\n"
				+ "	Participa das sessões, se engajando nas discussões e atividades sincronicas e assíncronas apesar de erros em potencial ou respostas incorretas. 				\n"
				+ "	Dá e aceita feedback a/de colegas, instrutores e / ou mentores e demosntrando que um feedback bem dado pode ajudar participantes a crescer.				\n"
				+ "	Aceita o desafio de utilizar novas ferramentas de tecnologia e se compromete a dominar o uso dessas ferramentas ao longo do tempo (por exemplo, Zoom e LMS escolhido)				\n"
				+ "	ORIENTAÇÃO PARA O FUTURO				\n"
				+ "	Dá o melhor de si na Generation e faz escolhas que indicam que entende a importância que esse programa tem em sua futura carreira e que pensa sobre seu futuro.	PONTUA 4/4 DA MÉTRICA	PONTUA 3/4 DA MÉTRICA	PONTUA 2/4 DA MÉTRICA	PONTUA 1/4 DA MÉTRICA (OU MENOS)\n"
				+ "	Articula as conexões entre a aprendizagem e sua futura carreira  e se concentra em ações concretas para alcançar seus objetivos da carreira.				\n"
				+ "	Estabelece metas SMART para desenvolver as habilidades necessárias para prosperar nessa profissão.				\n"
				+ "	Ajusta seus objetivos e pede ajuda a outros para permanecer no caminho certo.				\n"
				+ "	PERSISTÊNCIA				\n"
				+ "	Não desiste diante dos desafios ou depois de cometer um erro, principalmente em se tratando de dificuldades técnicas.	PONTUA 4/4 DA MÉTRICA	PONTUA 3/4 DA MÉTRICA	PONTUA 2/4 DA MÉTRICA	PONTUA 1/4 DA MÉTRICA (OU MENOS)\n"
				+ "	Mantém uma atitude positiva diante dos desafios (in cluindo desafios dentro e fora do programa).				\n"
				+ "	Faz perguntas esclarecedoras quando não entende um conceito que está sendo ensinado (via sessões assíncronas  ou sincrônicas, foruns de discussões e horários de atendimento).				\n"
				+ "	Completa todas as tarefas / atividades necessárias no programa.				\n"
				+ "COMMENTS:					\n"
				+ "✅	HABILIDADES COMPORTAMENTAIS				s\n"
				+ "	COMUNICAÇÃO	AVANÇADO	PROFICIENTE	EM DESENVOLVIMENTO	PRINCIPIANTE\n"
				+ "	Comunica idéias de forma clara, eficaz, concisa e profissional.	PONTUA 4/4 DA MÉTRICA	PONTUA 3/4 DA MÉTRICA	PONTUA 2/4 DA MÉTRICA	PONTUA 1/4 DA MÉTRICA (OU MENOS)\n"
				+ "	Demonstra linguagem corporal confiante e educada, inclusindo comunicação não verbal via contato por vídeo (ex.: permanece fisicamente engajado, escutando ativamente quando não está falando durante uma sessão virtual). 				\n"
				+ "	Participa de todas os fóruns de discussões, chats e atividades dadas.				\n"
				+ "	Escreve de forma clara, eficaz, concisa e profissional (fóruns de discussões, mensagens a instrutores/as).				\n"
				+ "	TRABALHO EM EQUIPE				\n"
				+ "	Trabalha em colaboração com colegas, inclusive participando plenamente de todas as atividades síncronas e assíncronas	PONTUA 4/4 DA MÉTRICA	PONTUA 3/4 DA MÉTRICA	PONTUA 2/4 DA MÉTRICA	PONTUA 1/4 DA MÉTRICA (OU MENOS)\n"
				+ "	Escuta ativamente e se comunica efetivamente com os colegas de classe.				\n"
				+ "	Dá e pede ajuda de forma adequada enquanto estiver no programa.				\n"
				+ "	Permanece calmo e motiva seus colegas em situações desafiadoras.				\n"
				+ "	PROATIVIDADE				\n"
				+ "	Encontra oportunidades para liderar tarefas ou projetos sem ser solicitado/a.	PONTUA 4/4 DA MÉTRICA	PONTUA 3/4 DA MÉTRICA	PONTUA 2/4 DA MÉTRICA	PONTUA 1/4 DA MÉTRICA (OU MENOS)\n"
				+ "	Identifica e executa ações concretas que levam a melhoria pessoal, para o grupo, ou para o espaço / programa físico e virtual.				\n"
				+ "	Antecipa situações e ações que seriam necessárias.				\n"
				+ "	Solicita oportunidades extras e tempo para praticar novas habilidades, se necessário, ou oferece assistência a outras pessoas sem ser solicitado/a.				\n"
				+ "	ORIENTAÇÃO AO DETALHE				\n"
				+ "	Presta muita atenção a erros e maneiras de melhorar seu trabalho (por exemplo, codificação).	PONTUA 4/4 DA MÉTRICA	PONTUA 3/4 DA MÉTRICA	PONTUA 2/4 DA MÉTRICA	PONTUA 1/4 DA MÉTRICA (OU MENOS)\n"
				+ "	Verifica novamente o código desenhado por si/ pelos outros e testa se ele funciona corretamente antes de finalizá-lo.				\n"
				+ "					\n"
				+ "	Conclui tarefas com precisão e cuidado desde a primeira vez.";
	}
	
	@GetMapping
	public String hello3() {
		return "Ser reconhecido como um desenvolvedor, primeiramente dentro da Organização do Mercado Livre";
	}
}
