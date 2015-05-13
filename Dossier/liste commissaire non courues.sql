select distinct regate.NOM_REG,regate.DATE_REGATE,commissaires.NOM,commissaires.COM_REG, participation.STATUT_ARRIV from
regate inner join commission_de_course on regate.ID_COM = commission_de_course.ID_COM
inner join fait_partie2 on commission_de_course.ID_COM = fait_partie2.ID_COM
inner join commissaires on fait_partie2.ID_COMMISSAIRE = commissaires.ID_COMMISSAIRE
inner join participation on regate.CODE_RE = participation.CODE_RE
where regate.DATE_REGATE < curdate()
order by regate.DATE_REGATE asc
