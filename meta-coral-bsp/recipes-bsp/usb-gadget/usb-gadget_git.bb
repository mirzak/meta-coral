SUMMARY = "USB Gagdget Services"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=90b825e31d1d74dc87b4888a30271e33"

SRC_URI = "git://coral.googlesource.com/usb-gadget;protocol=https \
           file://usb-gadget.init \
"

SRCREV ="15d2ebc5fdccbbe6699c109ea0a5335a921037de"
RDEPENDS_${PN} += "bash networkmanager"

inherit update-rc.d systemd
PACKAGES =+ "${PN}-gs0"
S = "${WORKDIR}/git"

INITSCRIPT_NAME = "usb-gadget"
SYSTEMD_PACKAGES = "${PN} ${PN}-gs0"
SYSTEMD_SERVICE_${PN} = "usb-gadget.service"
SYSTEMD_SERVICE_${PN}-gs0 = "usb-gadget-getty-ttyGS0.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"
SYSTEMD_AUTO_ENABLE_${PN}-gs0 = "enable"

do_install() {
        # Install init scripts and set correct config directory
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/usb-gadget.init  ${D}${sysconfdir}/init.d/usb-gadget
        # Install systemd unit files
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${S}/debian/usb-gadget.service ${D}${systemd_unitdir}/system
        install -m 0644 ${S}/debian/usb-gadget-getty-ttyGS0.service ${D}${systemd_unitdir}/system
        # Install start/stop scripts
        install -d ${D}${bindir}
        install -m 0755 ${S}/usr/bin/usb-gadget-start.sh ${D}${bindir}/
        install -m 0755 ${S}/usr/bin/usb-gadget-stop.sh ${D}${bindir}/
        # Install dnsmasq config
        install -d ${D}${sysconfdir}/dnsmasq.d
        install -m 0644 ${S}/etc/dnsmasq.d/02-usb-gadget ${D}${sysconfdir}/dnsmasq.d
        install -m 0644 ${S}/etc/dnsmasq.d/99-no-default-dns ${D}${sysconfdir}/dnsmasq.d
        install -m 0644 ${S}/etc/dnsmasq.d/99-no-default-route ${D}${sysconfdir}/dnsmasq.d
}

FILES_${PN} = "${bindir} ${sysconfdir} ${systemd_unitdir}"
