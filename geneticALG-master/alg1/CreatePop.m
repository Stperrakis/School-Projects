function pop = CreatePop(nvar,popNum,tolera,startP)
for i= 1 : popNum   
    for j = 1:nvar
      r = tolera(1) + (tolera(2)-tolera(1)).*rand(1);
     
      pop(i,j) = startP(j)+r;
    end 
end    
end


