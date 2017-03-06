INSERT into cliente(cpf, nomeCli, telefone, email) VALUES
	('30484235168', 'Durval Vasconcelos', '81986379743','zagueiro.durval@sport.com.br'),
    ('88609727289', 'Antonio Joaquim', '85987997142','antonio_joaquim@hotmail.com'),
    ('45040737149', 'Ronaldo Ferreira', '9538413847', 'ronaldo.ferreira@gmail.com'),
    ('67566648241', 'Alana Beatriz', '61981368873', 'alana.beatriz.gomes@gmail.com'),
    ('27065121216', 'Victor Gonçalves', '96997621689', 'santos.victor@hotmail.com'),
    ('57573185383', 'Nicole Barros', '1835327530', 'nicole_barros2014@hotmail.com');
    
INSERT into material(codMat, descricao) VALUES
    ('10001092336', 'Tela Xiaomi Redmi Note 3 Pro'),
    ('03145789100', 'Bateria Apple iPhone 5S'),
    ('23414610091', 'Bateria Samsung Galaxy S8'),
    ('31023100091', 'Bateria Apple iPhone 7'),
    ('82647100948', 'Bateria Apple iPhone 6'),
    ('15910035748', 'Touch Samsung Galaxy J7'),
    ('64910097680', 'Touch Apple iPhone 6'),
    ('05541008762', 'Touch Apple iPhone 5S'),
	('40041100111', 'Tela Redmi 2 e Redmi 2 Pro');  
    
INSERT into smartphone(codCelular, numSerie, modelo, marca, cor, cpf) VALUES
	('09923656367', '02111111111', 'iPhone 7', 'Apple', 'Rose', '67566648241'),
    ('03604350534', '03121111111', 'Mi5S', 'Xiaomi','Golden', '45040737149'),
    ('03740354386', '05131111111', 'Redmi Note 3 Pro', 'Xiaomi',  'Gray', '27065121216'),
    ('03008174853', '04141111111', 'Redmi 2 Pro', 'Xiaomi', 'Black', '88609727289'),
    ('01586395690', '01151111111', 'A4', 'Samsung', 'Preto', '30484235168'),
    ('01396529276', '06161111111', 'J7', 'Samsung', 'Cinza', '30484235168'),
	('02108174853', '01131113110', 'Mi 5', 'Xiaomi', 'Golden', '88609727289');
	
INSERT into reparo (codCelular, dataExecutada, dataUltimoConserto) VALUES
	('03740354386', '2017-03-05', '2017-03-03'),
	('03008174853', '2017-02-28', '2015-12-12'),
	('01396529276', '2017-01-31', '2017-01-01'),
	('01586395690', '2016-06-19', '2016-02-04'),
	('09923656367', '2017-01-28', '2017-03-05'),
	('03740354386', '2017-03-07', '2017-03-31'),
	('03604350534', '2017-03-31', '2017-03-03');
	
INSERT into material_reparo (codCelular, dataExecutada, codMat, quantidade) VALUES
	('03008174853', '2017-02-28', '40041100111', 1),
	('09923656367', '2017-01-28', '31023100091', 1);

