package com.javaee.rodrigoandrades.projeto_final.listeners;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.javaee.rodrigoandrades.projeto_final.config.EmailConfig;
import com.javaee.rodrigoandrades.projeto_final.config.RabbitMQConfig;
import com.javaee.rodrigoandrades.projeto_final.domain.Cliente;
import com.javaee.rodrigoandrades.projeto_final.domain.Venda;

@Component
public class VendaListener {
	static final Logger logger = LoggerFactory.getLogger(VendaListener.class);
	
    @RabbitListener(queues = RabbitMQConfig.QUEUE_MESSAGES)
    public void processaVenda(Venda venda) {
    	Cliente vendedor = venda.getAcao().getCliente();
    			
    	venda.getAcao().setCliente(venda.getComprador());
    	venda.getAcao().setDataCompra(new Date());
    	venda.getAcao().setValorAtual(venda.getValor());
    	
    	enviarEmail(vendedor.getEmail(), "Venda realizada com sucesso.");
    	enviarEmail(venda.getComprador().getEmail(), "Compra realizada com sucesso.");
    	
    	
    	logger.info("Vendedor:");
    	logger.info(venda.getVendedor().getNome());
    	
    	logger.info("Comprador:");
    	logger.info(venda.getComprador().getNome());
    	
    	logger.info("Valor Ação:");
    	logger.info(venda.getValor().toString());
    }
    
    private void enviarEmail(String para, String msg) {
    	final String fromEmail = "rodrigomail2007@gmail.com";
		final String password = "******";
		final String assunto = "Venda de ações";

		EmailConfig config = new EmailConfig();
		config.sendEmail(fromEmail, password, para, assunto, msg);
    }
}
