//清理评测账号

delete from  t_user where dah like 'PC%';
delete  from  t_user_role where dah like 'PC%';
delete  from  t_evaluate_record where dah like 'PC%';