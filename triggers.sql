CREATE TRIGGER delete_orderlines_on_order_delete AFTER DELETE on ORDERS
FOR EACH ROW
BEGIN
DELETE FROM ORDER_LINES
    WHERE orderid = old.id;
END