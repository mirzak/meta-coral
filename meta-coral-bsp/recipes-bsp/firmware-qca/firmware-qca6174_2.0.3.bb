# Copyright 2019 NXP

require firmware-qca.inc

SUMMARY = "Qualcomm Wi-Fi and Bluetooth firmware"
DESCRIPTION = "Qualcomm Wi-Fi and Bluetooth firmware for modules such as QCA6174A"
SECTION = "base"
LICENSE = "Proprietary"

inherit allarch

do_install () {
    # Install firmware.conf for QCA modules
    install -d ${D}${sysconfdir}/bluetooth
    install -m 644 ${S}/1CQ_QCA6174A_LEA_2.0/etc/bluetooth/firmware.conf ${D}${sysconfdir}/bluetooth

    # Install firmware files
    install -d ${D}${nonarch_base_libdir}
    cp -r ${S}/1CQ_QCA6174A_LEA_2.0/lib/firmware ${D}${nonarch_base_libdir}
}

FILES:${PN} = " \
    ${sysconfdir}/bluetooth/firmware.conf \
    ${nonarch_base_libdir}/firmware/qca6174 \
    ${nonarch_base_libdir}/firmware/wlan \
    ${nonarch_base_libdir}/firmware/* \
"
