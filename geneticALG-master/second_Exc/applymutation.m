function [child1,child2] = applymutation1(a,b,nvar,Pc,pm)

Pc = 1-Pc;
child1 = a;
child2 = b;
h =1 ;

   Pcc = rand(1);
    if Pcc>=Pc
        child1(:,1:50) = child2(:,51:100);
        child2(:,1:50) = a(:,1:50);
    end

for i =1 : length(a)
    mutate_a = rand(1);
    mutate_b = rand(1);
   
    if mutate_a>=1-pm
        child1(:,i) =~ child1(:,i);
    end
    if mutate_b>=pm
        child2(:,i) =~ child2(:,i);
    end
    
end

