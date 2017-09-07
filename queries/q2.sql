SELECT p.program,
            p.spid,
            pm.category,
            pm.allocated,
            pm.used,
            pm.max_allocated
       FROM V$PROCESS p, V$PROCESS_MEMORY pm;