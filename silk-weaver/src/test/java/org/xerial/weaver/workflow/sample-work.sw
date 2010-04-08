

-type
 -id: seqtype
 -value*: [hg17, hg18, hg19]

-task 
 -id:			seq-archive
 -command: 		wget -O $(OUT:tar.gz) http://hgdownload.cse.ucsc.edu/goldenPath/$(IN:seqtype)/bigZips/chromFa.tar.gz 
 -descrption: 	download human genome sequence from UCSC

-task 
 -id:			sequence
 -command: 		tar xvfz $(IN:tar.gz) -C $(OUTDIR:fasta)
 
-task 
 -id: 			fasta-CT
 -command: 		weaver bisulfite convert -t CtoT $(IN:fasta) -t $(OUT:fasta)
 -description: 	Apply C->T conversion

-task 
 -id: 			fasta-GA
 -command: 		weaver bisulfite convert -t GtoA $(IN:fasta) -t $(OUT:fasta)
 -description: 	Apply G->A conversion


-task
 -id: 				blastDB
 -command: 			formatdb -i $(IN:fasta) -p F -o T
 -has local output: true
 -descrption: 		create sequence database for Blast alignment
 
-task
 -id: 			align-plus 
 -command: 		blastall -p megablast -d $(IN:blastDB) -g F -i $(IN:fasta) -m 9 -o $(OUT:blast) -S 1 
 -description: 	alignment to forward starnd only
 
-task
 -id: 			align-minus 
 -command: 		blastall -p megablast -d $(IN:blastDB) -g F -i $(IN:fasta) -m 9 -o $(OUT:blast) -S 2
 -description: 	alignment to reverse starnd only
 

-task
 -id:			alignmentDB
 -command:		weaver db create -s blastDB.schema $(IN:blast) -o $(OUT) 
 -description:	create a database index for browsing alignment result in UTGB 


