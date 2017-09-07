select
   t1.sid, 
   t1.username, 
   t2.xidusn, 
   t2.used_urec, 
   t2.used_ublk
from
   v$session     t1, 
   v$transaction t2
where
   t1.saddr = t2.ses_addr;