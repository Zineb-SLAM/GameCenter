DELIMITER |

CREATE TRIGGER update_stocks BEFORE UPDATE

ON ORDERS FOR EACH ROW

BEGIN

    IF NEW.paid = 1

      THEN

      	SELECT id INTO @order_lines_ids FROM ORDER_LINES WHERE orderid = NEW.id;
        SET NEW.sexe = NULL;

    END IF;

END |

DELIMITER 