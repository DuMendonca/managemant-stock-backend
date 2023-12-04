package com.gerenciamentoestoque.chegaRapidex.listener;

import com.gerenciamentoestoque.chegaRapidex.entities.User;
import com.gerenciamentoestoque.chegaRapidex.service.SequenceGeneratorService;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

public class UserModelListener extends AbstractMongoEventListener<User>
{
	SequenceGeneratorService sequenceGenerator;

	@Override
	public void onBeforeConvert(BeforeConvertEvent<User> event) {
		if (event.getSource().getUserId() < 1) {
			//event.getSource().setUserId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
		}
	}
}
