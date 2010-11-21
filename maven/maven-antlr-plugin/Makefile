
MVN:=mvn

TAG:=maven-antlr-plugin-1.8
RELEASE_OPT:="-DlocalCheckout=true"
MVN_OPT:=

release-prepare:
	$(MVN) release:prepare $(RELEASE_OPT) $(MVN_OPT)

release-perform:
	$(MVN) release:perform $(RELEASE_OPT) $(MVN_OPT)

release-sf:
	$(MVN) release:perform $(RELEASE_OPT) $(MVN_OPT) -Darguments="-Psourceforge" -Dtag="$(TAG)"


