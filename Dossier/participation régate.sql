select membre_d_equipage.ID_MEMBRE, membre_d_equipage.NOM_MEMBRE, membre_d_equipage.NUM_LICENCE,regate.NOM_REG,regate.DATE_REGATE,voilier.NOM_VOILE,participation.ID_SKIPPER
from membre_d_equipage inner join participe on membre_d_equipage.ID_MEMBRE=participe.ID_MEMBRE
inner join participation on participe.ID_PART=participation.ID_PART
inner join regate on participation.CODE_RE = regate.CODE_RE
inner join voilier on participation.NUM_VOILE = voilier.NUM_VOILE
where regate.CODE_RE = 1
order by membre_d_equipage.ID_MEMBRE asc