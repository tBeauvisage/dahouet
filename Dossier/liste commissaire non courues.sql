select distinct regate.NOM_REG,regate.DATE_REGATE,personne.NOM_PERSONNE,personne.PRENOM_PERS,commissaires.COM_REG, participation.STATUT_ARRIV from
regate inner join commission_de_course on regate.ID_COMISSION = commission_de_course.ID_COMISSION
inner join fait_partie2 on commission_de_course.ID_COMISSION = fait_partie2.ID_COMISSION
inner join commissaires on fait_partie2.ID_COMMISSAIRE = commissaires.ID_COMMISSAIRE
inner join participation on regate.CODE_RE = participation.CODE_RE
inner join personne on personne.ID_PERSONNE = commissaires.ID_COMMISSAIRE
where regate.DATE_REGATE < curdate()
order by regate.DATE_REGATE asc
