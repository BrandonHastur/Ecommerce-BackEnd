DROP SEQUENCE SEQ_CLIENTE;
DROP SEQUENCE SEQ_PEDIDO;
DROP SEQUENCE SEQ_PRODUCTO;


CREATE SEQUENCE SEQ_CLIENTE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;


CREATE SEQUENCE SEQ_PEDIDO
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;


CREATE SEQUENCE SEQ_PRODUCTO
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

