select segment_name,sum(bytes)/1024/1024/1024 as "SIZE in GB" from user_segments where segment_name='TABLE_NAME' group by segment_name;