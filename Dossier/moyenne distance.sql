select challenge.ID_CHALL,challenge.NOM_CHALL,
challenge.ANNEE,(sum(regate.DISTANCE)) /(count( regate.ID_CHALL)) as moyenne_distance
from challenge
inner join regate on challenge.ID_CHALL=regate.ID_CHALL
where challenge.ID_CHALL=1 and regate.COURUE='y';