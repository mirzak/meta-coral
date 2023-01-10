# Use this class for U-Boot 2017.03 or older.

DEPENDS:append = " dtc-145-native"

do_configure:prepend () {
    sed -i -e 's/^DTC[[:space:]]*=[[:space:]]*dtc[[:space:]]*$/DTC = dtc-145/' ${S}/Makefile
}
