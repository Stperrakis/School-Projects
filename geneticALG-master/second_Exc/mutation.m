function [ out,state ] = mutation( fitness_values,Pc,state,nvar,pm )
%MUTATION Summary of this function goes here
%   Detailed explanation goes here
%% mutation with a single crossover digit.
% num=fix(size(fitness_values,1)*0.3);
num= size(fitness_values,1);
% if mod(num,2)
%     num = num-1;
% end
% if num<=1
%     out = 0;
% end

for i = 1:2:num
   
    %[ child1,child2,ppl,found ]
    [a,b,fitness_values,found] = roulette(fitness_values);
    if found == 0
        out(i,:) = fitness_values(a,1:nvar);
        out(i+1,:) = fitness_values(a,1:nvar);
        state = 0;
        break
    end
    [child1,child2] = applymutation(fitness_values(a,1:nvar),fitness_values(a,1:nvar),nvar,Pc,pm);
    out(i,:) = child1;
    out(i+1,:) = child2;
end

end

